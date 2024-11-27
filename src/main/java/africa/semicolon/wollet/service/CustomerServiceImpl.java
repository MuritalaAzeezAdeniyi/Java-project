package africa.semicolon.wollet.service;

import africa.semicolon.wollet.dtos.request.DepositRequest;
import africa.semicolon.wollet.dtos.request.RegisterCustomerRequest;
import africa.semicolon.wollet.dtos.request.UpdateCustomerRequest;
import africa.semicolon.wollet.dtos.request.WalletDepositRequest;
import africa.semicolon.wollet.dtos.response.*;
import africa.semicolon.wollet.execption.CustomerNotExistException;
import africa.semicolon.wollet.execption.CustomerNotFoundException;
import africa.semicolon.wollet.execption.RegisterValidationException;
import africa.semicolon.wollet.execption.UserNotFoundException;
import africa.semicolon.wollet.model.Customer;
import africa.semicolon.wollet.model.Wallet;
import africa.semicolon.wollet.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final WalletServiceImpl walletServiceImpl;
    private final ModelMapper modelMapper;

    //    private final WalletService walletService;
    @Override
    public DepositResponse deposit(DepositRequest depositRequest) throws UserNotFoundException {
        Customer customer = customerRepository.findById(depositRequest.getCustomerId())
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("user with id %d not found", depositRequest.getCustomerId())
                ));

        Wallet wallet = customer.getWallet();
        WalletDepositRequest walletDepositRequest = new WalletDepositRequest();
        walletDepositRequest.setId(wallet.getId());
        walletDepositRequest.setAmount(depositRequest.getAmount());
        WalletDepositResponse response = walletServiceImpl.deposit(walletDepositRequest);
        var depositResponse = modelMapper.map(response, DepositResponse.class);
        depositResponse.setMessage("deposit successful");
        return depositResponse;
    }

    @Override
    public RegisterCustomerResponse registerCustomer(RegisterCustomerRequest registerCustomerRequest) throws CustomerNotExistException, RegisterValidationException {
        validateCustomerEmail(registerCustomerRequest);
        RegisRegistrationValidation(registerCustomerRequest);
        Customer customer = modelMapper.map(registerCustomerRequest, Customer.class);
        customer = customerRepository.save(customer);

        RegisterCustomerResponse registerCustomerResponse = modelMapper.map(customer, RegisterCustomerResponse.class);
        registerCustomerResponse.setMessage("register successful");
        return registerCustomerResponse;
    }

    @Override
    public FindCustomerResponse findCustomer(Long id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer  not fund"));
        return new FindCustomerResponse(customer.getEmail(), customer.getFirstName(), customer.getLastName(), customer.getPassword());
    }

    @Override
    public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest updateCustomerRequest) throws UserNotFoundException, CustomerNotExistException {
        Customer customer = searchCustomer(updateCustomerRequest);
        customer.setFirstName(updateCustomerRequest.getFirstName());
        customer.setLastName(updateCustomerRequest.getLastName());
        customer.setPassword(updateCustomerRequest.getPassword());
        customer.setEmail(updateCustomerRequest.getEmail());
        customer = customerRepository.save(customer);

        UpdateCustomerResponse updateCustomerResponse = modelMapper.map(customer, UpdateCustomerResponse.class);
        updateCustomerResponse.setMessage("update successful");
        return updateCustomerResponse;
    }

    private void validateCustomerEmail(RegisterCustomerRequest request) throws CustomerNotExistException {
        Optional<Customer> customer = customerRepository.findByEmail(request.getEmail());
        if (customer.isPresent()) {
            throw new CustomerNotExistException(String.format("Customer with email %s already exist", request.getEmail()));
        }
    }

    private void RegisRegistrationValidation(RegisterCustomerRequest request) throws CustomerNotExistException, RegisterValidationException {
        if (request.getLastName().trim().isEmpty() ||
                request.getPassword().trim().isEmpty() ||
                request.getEmail().trim().isEmpty() ||
                request.getFirstName().trim().isEmpty()) {
            throw new RegisterValidationException("Wrong detail entered!");
        }
    }

    public Customer searchCustomer(UpdateCustomerRequest request) throws CustomerNotExistException {
        return customerRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new CustomerNotExistException(String.format("Customer with %s email not found", request.getEmail()
                )));

    }

}

