package com.poc.springsecurityopa.customers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    CustomerResponse toDto(CustomerRecord customerRecord);

    List<CustomerResponse> toDto(List<CustomerRecord> customerRecords);

    CustomerRecord toDomainObject(CustomerRequest customerRequest);

}
