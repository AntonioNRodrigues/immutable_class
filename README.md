# Immutable Class Example in Java

## Overview
This document explains the concept of creating an immutable class in Java. An immutable class is a class whose instances cannot be modified after they are created. This concept is useful in many scenarios, such as ensuring thread safety and preserving the integrity of objects.

## Characteristics of an Immutable Class
To create an immutable class in Java, follow these guidelines:
1. Declare the class as `final` so it cannot be subclassed.
2. Declare all fields as `private` and `final` to ensure they are initialized once and cannot be changed.
3. Initialize all fields via a constructor.
4. Do not provide any setters for the fields.
5. Ensure that all mutable fields (if any) are properly handled to prevent changes.

## Example Implementation
Below is an example implementation of an immutable class in Java, along with a mutable `Address` class to demonstrate handling mutable fields.

### ImmutableClass.java
```java
public final class ImmutableClass {
    private final String name;
    private final int age;
    private final Address address; // Assuming Address is a mutable class

    public ImmutableClass(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        // Create a defensive copy of the mutable field to ensure immutability
        this.address = new Address(address);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        // Return a defensive copy of the mutable field to prevent modifications
        return new Address(address);
    }

    // Override equals and hashCode methods for proper comparison and usage in collections
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImmutableClass that = (ImmutableClass) o;

        if (age != that.age) return false;
        if (!name.equals(that.name)) return false;
        return address.equals(that.address);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
