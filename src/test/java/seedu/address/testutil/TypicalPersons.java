package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.product.Product;

/**
 * A utility class containing a list of {@code Product} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Product ALICE = new ProductBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withSerialNumber("94351253")
            .withTags("friends").build();
    public static final Product BENSON = new ProductBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withSerialNumber("98765432")
            .withTags("owesMoney", "friends").build();
    public static final Product CARL = new ProductBuilder().withName("Carl Kurz").withSerialNumber("95352563")
            .withEmail("heinz@example.com").withAddress("wall street").build();
    public static final Product DANIEL = new ProductBuilder().withName("Daniel Meier").withSerialNumber("87652533")
            .withEmail("cornelia@example.com").withAddress("10th street").withTags("friends").build();
    public static final Product ELLE = new ProductBuilder().withName("Elle Meyer").withSerialNumber("9482224")
            .withEmail("werner@example.com").withAddress("michegan ave").build();
    public static final Product FIONA = new ProductBuilder().withName("Fiona Kunz").withSerialNumber("9482427")
            .withEmail("lydia@example.com").withAddress("little tokyo").build();
    public static final Product GEORGE = new ProductBuilder().withName("George Best").withSerialNumber("9482442")
            .withEmail("anna@example.com").withAddress("4th street").build();

    // Manually added
    public static final Product HOON = new ProductBuilder().withName("Hoon Meier").withSerialNumber("8482424")
            .withEmail("stefan@example.com").withAddress("little india").build();
    public static final Product IDA = new ProductBuilder().withName("Ida Mueller").withSerialNumber("8482131")
            .withEmail("hans@example.com").withAddress("chicago ave").build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Product product : getTypicalPersons()) {
            ab.addPerson(product);
        }
        return ab;
    }

    public static List<Product> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
