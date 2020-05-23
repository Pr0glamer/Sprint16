package com.softserve.itacademy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressBookDao {

    private AddressBook record = new AddressBook(10);

    private static AddressBookDao instance = null;

    public static AddressBookDao getInstance(){
        if(instance == null) {
            instance = new AddressBookDao();
            return instance;
        }
        return instance;
    }

    private AddressBookDao() {

    }

    public boolean create(String firstName, String lastName, String address) {

       return record.create(firstName, lastName, address);
    }

    public String read(String firstName, String lastName) {

        return record.read(firstName, lastName);

    }


    public boolean update(String firstName, String lastName, String address) {

          return record.update(firstName, lastName, address);
    }

    public boolean delete(String firstName, String lastName) {
          return record.delete(firstName, lastName);
//        return records.remove(read(firstName, lastName));

    }

    public List<String[]> readAll(SortOrder so) {

        record.sortedBy(so);

        List<String[]> view = new ArrayList<>();
        for(String st : record) {

            Pattern pattern = Pattern.compile("[A-Za-z ]+: ([A-Za-zА-Яа-я0-9 ]+)");
            Matcher matcher = pattern.matcher(st);
            int i = 0;
            String[] result = new String[3];
            while(matcher.find()) {
                result[i++] = matcher.group(1);
            }
            view.add(result);
         }


        return view;


    }



}
