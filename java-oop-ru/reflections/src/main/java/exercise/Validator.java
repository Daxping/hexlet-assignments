package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List <String> notValidFields = new ArrayList();
        try {
            for (Field field : address.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class) && field.get(address) == null) {
                    notValidFields.add(field.getName());
                }
            }
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }

        return notValidFields;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> result = new HashMap<>();
        int minLength = 0;

        List <String> nullError = new ArrayList();
        nullError.addAll(validate(address));

        List <String> minLengthError = new ArrayList();
        try {
            for (Field field : address.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(MinLength.class) &&
                        field.getAnnotation(MinLength.class).minLength() > field.get(address).toString().length()) {
                    minLength = field.getAnnotation(MinLength.class).minLength();
                    minLengthError.add(field.getName());
                }
            }
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }

        for (String key : nullError) {
            result.put(key, List.of("can not be null"));
        }

        for (String key : minLengthError) {
            result.put(key, List.of("length less than " + minLength));
            }

        return result;
    }
}

// END
