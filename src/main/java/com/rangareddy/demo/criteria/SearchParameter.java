package com.rangareddy.demo.criteria;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by RANGAREJ on 8/10/2017.
 */

public class SearchParameter {

    public static class RangeParameter<T> extends Parameter<T> {
        @JsonProperty("value2")
        private T value2;

        @JsonCreator
        public RangeParameter(
                @JsonProperty("value") T value,
                @JsonProperty("value2") T value2
        ) {
            super(Operator.Range, value);
            this.value2 = value2;
        }

        public T getValue2() {
            return value2;
        }
    }
    public static class StringParameter<T> extends Parameter<T> {
        @JsonCreator
        public StringParameter(
                @JsonProperty("operator") Operator operator,
                @JsonProperty("value") T value) {
            super(operator, value);
            if (operator == Operator.Range) {
                throw new RuntimeException("Operator Range not supported for String Parameter");
            }
        }
    }
    public static class DoubleParameter<T> extends Parameter<T> {
        @JsonProperty("value2")
        private T value2;
        @JsonCreator
        public DoubleParameter(
                @JsonProperty("value") T value1,
                @JsonProperty("value2") T value2) {
            super(Operator.Range, value1);
            this.value2=value2;
        }
        public T getValue2() {
            return value2;
        }
    }


    public abstract static class Parameter<T> {

        public enum Operator {
            Equals,
            Contains,
            StartsWith,
            Range,
            LessThan,
            GreaterThan,
            NotEquals
        };

        private Operator operator;

        private T value;

        public Parameter(
                Operator operator,
                T value) {
            this.operator = operator;
            this.value = value;
        }

        public Operator getOperator() {
            return operator;
        }

        public T getValue() {
            return value;
        }

    }

}