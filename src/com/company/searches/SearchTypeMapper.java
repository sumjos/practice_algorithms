package com.company.searches;

abstract public class SearchTypeMapper<T> {

    protected Class<T> genericClass;
    protected T arr[];
    protected T searchElement;

    protected String getValueFromGenericName() {
        return this.genericClass.getSimpleName();
    }

    protected boolean lessThanEqualCheck(T reference, T valToCheck) {
        switch (this.getValueFromGenericName()) {
            case "Integer":
                return (Integer)valToCheck <= (Integer)reference;
            case "String":
                return ((String)valToCheck).compareToIgnoreCase((String)reference) == -1 ||
                        ((String)valToCheck).compareToIgnoreCase((String)reference) == 0? true : false;
            default:
                return false;
        }
    }

    protected boolean greaterThanEqualCheck(T reference, T valToCheck) {
        switch (this.getValueFromGenericName()) {
            case "Integer":
                return (Integer)valToCheck >= (Integer)reference;
            case "String":
                return ((String)valToCheck).compareToIgnoreCase((String)reference) == 1 ||
                        ((String)valToCheck).compareToIgnoreCase((String)reference) == 0? true : false;
            default:
                return false;
        }
    }

    protected boolean equalCheck(T reference, T valToCheck) {
        switch (this.getValueFromGenericName()) {
            case "Integer":
                return (Integer)valToCheck == (Integer)reference;
            case "String":
                return ((String)valToCheck).compareToIgnoreCase((String)reference) == 0 ? true : false;
            default:
                return false;
        }
    }
}
