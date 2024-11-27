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
import africa.semicolon.wollet.execption.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;

    private static DepositRequest buildDepositAmount(Long customerId, BigDecimal depositAmount, String description) {
        DepositRequest walletDepositRequest = new DepositRequest();
        walletDepositRequest.setCustomerId(customerId);
        walletDepositRequest.setAmount(depositAmount);
        walletDepositRequest.setDescription(description);
        return walletDepositRequest;
    }

    @Test
    //@Sql(scripts = {"/db/data.sql"})
    public void testCustomerCanDeposit() throws UserNotFoundException {
        Long customerId = 1L;
        BigDecimal depositAmount = new BigDecimal("5000.00");
        String description = "This is just a test for deposit";
        DepositRequest walletDepositRequest = buildDepositAmount(customerId, depositAmount, description);
        DepositResponse depositResponse = customerService.deposit(walletDepositRequest);
        assertNotNull(depositResponse);
        assertNotNull(depositResponse.getMessage());
        assertEquals("SUCCESS", depositResponse.getStatus());


    }

    @Test
    public void testCanRegisterCustomer() throws UserNotFoundException {
        RegisterCustomerRequest registerCustomerRequest = new RegisterCustomerRequest();
        registerCustomerRequest.setFirstName("Azeez");
        registerCustomerRequest.setLastName("Adeniyi");
        registerCustomerRequest.setEmail("adeniyi@gmail.com");
        registerCustomerRequest.setPassword("123456");
        RegisterCustomerResponse response = customerService.registerCustomer(registerCustomerRequest);
        assertNotNull(response);
        assertNotNull(response.getMessage());
    }

    @Test
    public void testCanGetCustomer() throws CustomerNotFoundException {
        Long customerId = 52L;
        FindCustomerResponse findCustomerResponse = customerService.findCustomer(customerId);
        assertNotNull(findCustomerResponse);
        System.out.println(findCustomerResponse);
    }

    @Test
    public void testCanUpdateCustomer() throws CustomerNotExistException, UserNotFoundException {
        UpdateCustomerRequest updateCustomerRequest = new UpdateCustomerRequest();
        updateCustomerRequest.setCustomerId(52L);
        updateCustomerRequest.setFirstName("Mariam");
        updateCustomerRequest.setLastName("Abdulazeez");
        updateCustomerRequest.setEmail("abdulazeez@gmail.com");
        updateCustomerRequest.setPassword("123456");
        UpdateCustomerResponse updateCustomerResponse = customerService.updateCustomer(updateCustomerRequest);
        assertNotNull(updateCustomerResponse);
        assertNotNull(updateCustomerResponse.getMessage());
    }
}

