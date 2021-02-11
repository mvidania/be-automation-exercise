package com.mvidania.baautomation.models;

public enum PetEnum {

        AVAILABLE("available"),

        PENDING("pending"),

        SOLD("sold");

        private String value;

        PetEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        @Override
        public String toString() {
            return String.valueOf(value);
        }

}
