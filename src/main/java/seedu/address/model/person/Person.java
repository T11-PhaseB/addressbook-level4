package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.Insurance.Insurance;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.UniqueTagList;
import seedu.address.model.group.Group;
import seedu.address.model.group.UniqueGroupList;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    private final Name name;
    private final Phone phone;
    private final Email email;
    private final Address address;
    private final Birthday birthday;
    private final Appointment appointment;
    private final Group group;
    private final Insurance insurance;

    private final UniqueTagList tags;
    private final UniqueGroupList groups;

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Address address, Set<Tag> tags, Birthday birthday,
            Appointment appointment, Group group, Insurance insurance) {
        requireAllNonNull(name, phone, email, address, tags, birthday);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
        this.appointment = appointment;
        this.group = group;
        this.insurance = insurance;
        // protect internal tags from changes in the arg list
        this.tags = new UniqueTagList(tags);
        this.groups = new UniqueGroupList(group);

    }

    /**
     * TODO: To be phased out
     */

        public Person(Name name, Phone phone, Email email, Address address, Set<Tag> tags, Birthday birthday,
            Appointment appointment, Group group) {
        requireAllNonNull(name, phone, email, address, tags, birthday);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
        this.appointment = appointment;
        this.group = group;
        this.insurance = null;
        // protect internal tags from changes in the arg list
        this.tags = new UniqueTagList(tags);
        this.groups = new UniqueGroupList(group);

    }


    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public Birthday getBirthday() {
        return birthday;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public Group getGroup() {
            return group;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags.toSet());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return otherPerson.getName().equals(this.getName())
                && otherPerson.getPhone().equals(this.getPhone())
                && otherPerson.getEmail().equals(this.getEmail())
                && otherPerson.getAddress().equals(this.getAddress())
                && otherPerson.getBirthday().equals(this.getBirthday())
                && otherPerson.getGroup().equals(this.getGroup());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, tags, birthday, appointment, group, insurance);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Phone: ")
                .append(getPhone())
                .append(" Email: ")
                .append(getEmail())
                .append(" Address: ")
                .append(getAddress())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }
}
