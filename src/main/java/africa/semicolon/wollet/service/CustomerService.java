package africa.semicolon.wollet.service;

import africa.semicolon.wollet.dtos.request.DepositRequest;
import africa.semicolon.wollet.dtos.request.RegisterCustomerRequest;
import africa.semicolon.wollet.dtos.request.UpdateCustomerRequest;
import africa.semicolon.wollet.dtos.response.DepositResponse;
import africa.semicolon.wollet.dtos.response.FindCustomerResponse;
import africa.semicolon.wollet.dtos.response.RegisterCustomerResponse;
import africa.semicolon.wollet.dtos.response.UpdateCustomerResponse;
import africa.semicolon.wollet.execption.CustomerNotExistException;
import africa.semicolon.wollet.execption.CustomerNotFoundException;
import africa.semicolon.wollet.execption.RegisterValidationException;
import africa.semicolon.wollet.execption.UserNotFoundException;

public interface CustomerService {
    DepositResponse deposit(DepositRequest depositRequest) throws UserNotFoundException;

    RegisterCustomerResponse registerCustomer(RegisterCustomerRequest registerCustomerRequest) throws UserNotFoundException, CustomerNotExistException, RegisterValidationException;

    FindCustomerResponse findCustomer(Long id) throws CustomerNotFoundException;

    UpdateCustomerResponse updateCustomer(UpdateCustomerRequest updateCustomerRequest) throws UserNotFoundException, CustomerNotExistException;
}
