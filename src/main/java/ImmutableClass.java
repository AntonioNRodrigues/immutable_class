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
