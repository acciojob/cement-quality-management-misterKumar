package com.driver;

import java.util.*;


import java.util.*;
import java.util.*;

public class CementQualityManagement<T extends Number> {
    private Map<String, Map<String, List<T>>> store = new HashMap<>();

    public String addCementBrand() {
       // your code goes here
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Brand Name: ");
        String brandName = scanner.nextLine();

        if (store.containsKey(brandName)) {
            return "Brand already exists.";
        }

        Map<String, List<T>> brandParameters = new HashMap<>();
        while (true) {
            System.out.print("Quality Parameter Name (or 'exit' to finish): ");
            String paramName = scanner.nextLine();
            if (paramName.equals("exit")) {
                break;
            }
            System.out.print("Quality Parameter Value: ");
            T paramValue = parseInput(scanner.nextLine());
            if (paramValue != null) {
                brandParameters.putIfAbsent(paramName, new ArrayList<>());
                brandParameters.get(paramName).add(paramValue);
            } else {
                System.out.println("Invalid input. Quality parameter value must be a number.");
            }
        }

        store.put(brandName, brandParameters);
        return "Brand " + brandName + " added successfully!";
    }

    public void fetchQualityParameters(String brandName) {
        // your code goes here
        if (!store.containsKey(brandName)) {
            throw new BrandNotFoundException("Brand not found.");
        }

        System.out.println("Quality Parameters for Brand " + brandName + ":");
        Map<String, List<T>> brandParameters = store.get(brandName);
        for (Map.Entry<String, List<T>> entry : brandParameters.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    public double computeAverageValue(String brandName, String paramName) {
      // your code goes here

        if (!store.containsKey(brandName)) {
            throw new BrandNotFoundException("Brand not found.");
        }

        Map<String, List<T>> brandParameters = store.get(brandName);
        if (!brandParameters.containsKey(paramName)) {
            throw new ParameterNotFoundException("Parameter not found for brand " + brandName);
        }

        List<T> parameterValues = brandParameters.get(paramName);
        double sum = 0;
        for (T value : parameterValues) {
            sum += value.doubleValue();
        }

        return sum / parameterValues.size();
    }

    private T parseInput(String input) {
		
        // your code goes here
        try {
            @SuppressWarnings("unchecked")
            T value = (T) Double.valueOf(input);
            return value;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static class BrandNotFoundException extends RuntimeException {
        // your code goes here
        public BrandNotFoundException(String message) {
            super(message);
        }
    }

    static class ParameterNotFoundException extends RuntimeException {
        // your code goes here
        public ParameterNotFoundException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        CementQualityManagement<Double> cementManager = new CementQualityManagement<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scenario: Adding a Cement Brand");
        System.out.println(cementManager.addCementBrand());

        System.out.println("\nScenario: Fetching Quality Parameters of a Brand");
        System.out.print("Enter Brand Name: ");
        String brandName = scanner.nextLine();
        cementManager.fetchQualityParameters(brandName);

        System.out.println("\nScenario: Computing Average Value of a Quality Parameter");
        System.out.print("Enter Brand Name: ");
        brandName = scanner.nextLine();
        System.out.print("Enter Quality Parameter Name: ");
        String paramName = scanner.nextLine();
        double averageValue = cementManager.computeAverageValue(brandName, paramName);
        System.out.println("Average value of " + paramName + " for brand " + brandName + ": " + averageValue);

        scanner.close();
    }

	public void addCementBrandWithQualityParameters(String brandName, String paramName, T paramValue) {
		// TODO Auto-generated method stub
        if (!store.containsKey(brandName)) {
            store.put(brandName, new HashMap<>());
        }

        Map<String, List<T>> brandParameters = store.get(brandName);
        brandParameters.putIfAbsent(paramName, new ArrayList<>());
        brandParameters.get(paramName).add(paramValue);
	}
}



