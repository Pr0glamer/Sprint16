package com.softserve.itacademy;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

enum SortOrder {
    ASC, DESC
}

@SuppressWarnings("unchecked")
public class AddressBook implements Iterable<String> {
    private NameAddressPair[] addressBook;
    private int counter = 0;


    private static class NameAddressPair {
        private final Person person;
        private String address;

        @Override
        public String toString() {
            return
                    "First name: " + person.firstName +
                            ", Last name: " + person.lastName +
                            ", Address: " + address;
        }

        private NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }

        private static class Person {
            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            private String firstName;
            private String lastName;

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Person person = (Person) o;
                return Objects.equals(firstName, person.firstName) &&
                        Objects.equals(lastName, person.lastName);
            }

            @Override
            public int hashCode() {
                return Objects.hash(firstName, lastName);
            }

        }
    }


    @Override
    public String toString() {
        return "addressBook{" +
                "addressBook=" + Arrays.toString(addressBook) +
                ", counter=" + counter +
                '}';
    }

    public AddressBook(int size) {

        if (size < 0) {
            throw new IllegalArgumentException();
        }

        this.addressBook = new NameAddressPair[size];
    }

    public boolean ifPersonExists(NameAddressPair.Person p) {

        for (NameAddressPair np : addressBook) {
            if (np != null && np.person.equals(p)) {
                return true;
            }
        }
        return false;

    }

    public NameAddressPair.Person findPerson(String firstName, String lastName) {

        NameAddressPair.Person p = new NameAddressPair.Person(firstName, lastName);

        for (NameAddressPair np : addressBook) {
            if (np != null && np.person.equals(p)) {
                return np.person;
            }
        }
        return p;

    }


    public void checkSize() {
        if (counter == addressBook.length) {
            NameAddressPair[] newaddressBook = new NameAddressPair[addressBook.length * 2];
            System.arraycopy(addressBook, 0, newaddressBook, 0, addressBook.length);
            addressBook = newaddressBook;
        }
    }


    public boolean create(String firstName, String lastName, String address) {

        NameAddressPair.Person p = new NameAddressPair.Person(firstName, lastName);

        if (!ifPersonExists(p)) {
            checkSize();
            NameAddressPair nap = new NameAddressPair(p, address);
            addressBook[counter++] = nap;
            return true;

        } else {
            return false;
        }

    }

    public String read(String firstName, String lastName) {

        NameAddressPair.Person p = new NameAddressPair.Person(firstName, lastName);

        for (NameAddressPair np : addressBook) {
            if (np != null && np.person.equals(p)) {
                return np.address;
            }
        }
        return null;

    }

    public boolean update(String firstName, String lastName, String address) {

        NameAddressPair.Person p = new NameAddressPair.Person(firstName, lastName);
        if (!ifPersonExists(p)) {
            return false;
        } else {
            for (NameAddressPair np : addressBook) {
                if (np != null && np.person.equals(p)) {
                    np.address = address;
                    break;
                }
            }
        }
        return true;

    }

    public boolean delete(String firstName, String lastName) {

        NameAddressPair.Person p = new NameAddressPair.Person(firstName, lastName);
        if (!ifPersonExists(p)) {
            return false;
        } else {

            int indexToDeletion = 0;

            for (int i = 0; i < addressBook.length; i++) {
                if (addressBook[i] != null && addressBook[i].person.equals(p)) {
                    indexToDeletion = i;
                    counter--;
                    break;
                }
            }

            for (int i = indexToDeletion; i < addressBook.length; i++) {
                addressBook[i] = (i + 1 == addressBook.length) ? null : addressBook[i + 1];
            }

        }
        return true;

    }

    public int size() {
        return counter;
    }

    public void sortedBy(SortOrder order) {
        if (order == SortOrder.ASC) {

            Arrays.sort(addressBook, new Comparator<NameAddressPair>() {
                @Override
                public int compare(NameAddressPair o1, NameAddressPair o2) {
                    if (o1 == null) {
                        return 1;
                    } else if (o2 == null) {
                        return -1;
                    } else if (!o1.person.firstName.equals(o2.person.firstName)) {
                        return o1.person.firstName.compareTo(o2.person.firstName);

                    } else {
                        return o1.person.lastName.compareTo(o2.person.lastName);
                    }

                }
            });
        } else {
            Arrays.sort(addressBook, new Comparator<NameAddressPair>() {
                @Override
                public int compare(NameAddressPair o1, NameAddressPair o2) {
                    if (o2 == null) {
                        return -1;
                    } else if (o1 == null) {
                        return 1;
                    }
                    if (!o1.person.firstName.equals(o2.person.firstName)) {
                        return o2.person.firstName.compareTo(o1.person.firstName);

                    } else {
                        return o2.person.lastName.compareTo(o1.person.lastName);
                    }

                }
            });
        }


    }

    @SuppressWarnings("unchecked")
    private class AddressBookIterator implements Iterator {

        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < AddressBook.this.counter;
        }

        @Override
        public String next() {
            return addressBook[counter++].toString();
        }
    }

    @Override
    public Iterator iterator() {
        return new AddressBookIterator();

    }

    /*@Override
    public Iterator iterator() {
        return new Iterator() {
            private int counter = 0;
            @Override
            public boolean hasNext() {
                return counter < AddressBook.this.counter;
            }
            @Override
            public Object next() {
                return addressBook[counter++];
            }
        };
    }*/
}


