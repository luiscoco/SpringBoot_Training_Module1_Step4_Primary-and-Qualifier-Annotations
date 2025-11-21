package com.luxoft.flights;

import com.luxoft.flights.model.Flight;
import com.luxoft.flights.services.DataLoader;
import com.luxoft.flights.services.DataService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class FlightsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightsApplication.class, args);
    }

    @Bean
    CommandLineRunner run(DataService dataService, @Qualifier("dbDataLoader") DataLoader dataLoader) {
        return args -> {
            dataLoader.loadData();
            System.out.println("Data loaded successfully.");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Choose an option:");
                System.out.println("1. Show all flights from a specific airport");
                System.out.println("2. Show all flights of a specific carrier");
                System.out.println("3. Show all flights by state");
                System.out.println("4. Show all states");
                System.out.println("5. Show all airports");
                System.out.println("6. Show all carriers");
                System.out.println("7. Show number of flights");
                System.out.println("0. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter airport code: ");
                        String airportCode = scanner.nextLine();
                        List<Flight> flightsFromAirport = dataService.getFlightsByOrigin(airportCode);
                        flightsFromAirport.forEach(System.out::println);
                        break;
                    case 2:
                        System.out.print("Enter carrier code: ");
                        String carrierCode = scanner.nextLine();
                        List<Flight> flightsByCarrier = dataService.getFlightsByCarrier(carrierCode);
                        flightsByCarrier.forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("Enter state name: ");
                        String stateName = scanner.nextLine();
                        List<Flight> flightsByState = dataService.getFlightsByState(stateName);
                        flightsByState.forEach(System.out::println);
                        break;
                    case 4:
                        dataService.getStates().forEach(System.out::println);
                        break;
                    case 5:
                        dataService.getAirports().forEach(System.out::println);
                        break;
                    case 6:
                        dataService.getCarriers().forEach(System.out::println);
                        break;
                    case 7:
                        System.out.println("Number of flights: " + dataService.getFlights().size());
                        break;

                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                        break;
                }
            }
        };
    }

}
