package com.sid.project.SpringBoot_CustomerAccount.ModelMapper;

import com.sid.project.SpringBoot_CustomerAccount.DTO.AccountDto;
import com.sid.project.SpringBoot_CustomerAccount.DTO.CustomerDto;
import com.sid.project.SpringBoot_CustomerAccount.Entity.Account;
import com.sid.project.SpringBoot_CustomerAccount.Entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ModelMapper
{
    Account accountDtoToAccount (AccountDto accountDto);

    AccountDto accountToAccountDto(Account account);

    Customer customerDtoToCustomer(CustomerDto customerDto);

    CustomerDto customerToCustomerDto(Customer customer);

}
