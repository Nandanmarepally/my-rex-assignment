
//Design an immutable class with following attributes
//String name;
//String Id,
//Date dateOfJoining
//List<Address> addresses;




import java.util.*;

final class ImmutableEmployee {
    private final String name;
    private final String id;
    private final Date dateOfJoining;
    private final List<Address> addresses;

    public ImmutableEmployee(String name, String id, Date dateOfJoining, List<Address> addresses) {
        this.name = name;
        this.id = id;
        this.dateOfJoining = new Date(dateOfJoining.getTime()); // Deep copy of Date

        // Deep copy of List<Address>
        List<Address> tempAddresses = new ArrayList<>();
        for (Address addr : addresses) {
            tempAddresses.add(new Address(addr)); // Assuming Address has a copy constructor
        }
        this.addresses = Collections.unmodifiableList(tempAddresses);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Date getDateOfJoining() {
        return new Date(dateOfJoining.getTime()); // Defensive copy
    }

    public List<Address> getAddresses() {
        List<Address> tempAddresses = new ArrayList<>();
        for (Address addr : addresses) {
            tempAddresses.add(new Address(addr));
        }
        return Collections.unmodifiableList(tempAddresses); // Defensive copy
    }
}

// Mutable Address class (should be designed properly for deep copying)
class Address {
    private String city;
    private String state;

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    // Copy constructor
    public Address(Address other) {
        this.city = other.city;
        this.state = other.state;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
