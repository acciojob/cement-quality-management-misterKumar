package com.driver;

import java.util.*;


import java.util.*;
import java.util.*;

public class CementQualityManagement<T extends Number> {
    private Map<String, Map<String, List<T>>> store = new HashMap<>();

    public String addCementBrand() {
       // your code goes here
        return "";
    }

    public void fetchQualityParameters(String brandName) {
        // your code goes here
    }

    public double computeAverageValue(String brandName, String paramName) {
      // your code goes here

        return 0;
    }

    private T parseInput(String input) {
		
        // your code goes here
    	return null;
    }

    public static class BrandNotFoundException extends RuntimeException {
        // your code goes here
    }

    static class ParameterNotFoundException extends RuntimeException {
        // your code goes here
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

	public void addCementBrandWithQualityParameters(String brandName, String string, int i) {
		// TODO Auto-generated method stub
		
	}
}



