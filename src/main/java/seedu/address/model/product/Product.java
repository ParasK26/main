package seedu.address.model.product;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.distributor.DistributorName;
import seedu.address.model.tag.Tag;

/**
 * Represents a Product in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Product {

    // Identity fields
    private final Name name;
    private final SerialNumber serialNumber;
    private final DistributorName distname;

    // Data fields
    private final Address address;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Product(Name name, SerialNumber serialNumber, DistributorName distname, Address address, Set<Tag> tags) {
        requireAllNonNull(name, serialNumber, distname, address, tags);
        this.name = name;
        this.serialNumber = serialNumber;
        this.distname = distname;
        this.address = address;
        this.tags.addAll(tags);
    }

    public Name getName() {
        return name;
    }

    public SerialNumber getSerialNumber() {
        return serialNumber;
    }

    public DistributorName getDistributor() {
        return distname;
    }

    public Address getProductInfo() {
        return address;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both persons of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Product otherProduct) {
        if (otherProduct == this) {
            return true;
        }

        return otherProduct != null
                && otherProduct.getName().equals(getName())
                && (otherProduct.getSerialNumber().equals(getSerialNumber())
                || otherProduct.getDistributor().equals(getDistributor()));
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Product)) {
            return false;
        }

        Product otherProduct = (Product) other;
        return otherProduct.getName().equals(getName())
                && otherProduct.getSerialNumber().equals(getSerialNumber())
                && otherProduct.getDistributor().equals(getDistributor())
                && otherProduct.getProductInfo().equals(getProductInfo())
                && otherProduct.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, serialNumber, distname, address, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Serial number: ")
                .append(getSerialNumber())
                .append(" Distributor: ")
                .append(getDistributor())
                .append(" Product info: ")
                .append(getProductInfo())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
