package com.poc.springsecurityopa.customers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    CustomerResponse toDto(CustomerRecord customerRecord);

    List<CustomerResponse> toDto(List<CustomerRecord> customerRecords);

    CustomerRecord toDomainObject(CustomerRequest customerRequest);
}
