package com.rangareddy.demo.criteria;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import javax.validation.Valid;
import java.time.ZonedDateTime;
@Builder
@Getter
public class EmployeeCriteria {
    @JsonProperty
    @Valid
    private SearchParameter.StringParameter<String> firstName;
    @JsonProperty
    @Valid
    private SearchParameter.StringParameter<String> lastName;
    @JsonProperty
    @Valid
    private SearchParameter.DoubleParameter<Double> salary;
    //Dates
    @JsonProperty
    @Valid
    private SearchParameter.RangeParameter<ZonedDateTime> dateOfBirth;

}
