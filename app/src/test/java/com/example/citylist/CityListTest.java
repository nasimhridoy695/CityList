package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    /**
     * tests the delete function
     */
    @Test
    public void testdelete(){
        CityList cityList = new CityList();
        City city = new City("Regina", "SK");
        City city1 = new City("Dhaka", "motijheel");
        cityList.add(city);
        cityList.add(city1);
        cityList.delete(city);
        assertTrue(!cityList.getCities(1).contains(city));

    }


    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * tests if the delete function is throwing exception if the city doesnot exist
     */
    @Test
    public void testdeleteException() {
        CityList cityList = new CityList();
        City city = new City("Regina", "SK");
        City city1 = new City("Dhaka", "motijheel");
        City city2 = new City("cumilla", "chandina");
        cityList.add(city);

        cityList.add(city1);
        cityList.add(city2);
        assertEquals(3,cityList.count());
        cityList.delete(city);
        assertEquals(2,cityList.count());
        assertThrows(IllegalArgumentException.class, () ->{
           cityList.delete(city);
        });
    }

    /**
     * checks the count function
     */
    @Test
    public void testcount() {
        CityList cityList = new CityList();
        City city = new City("Regina", "SK");
        City city1 = new City("Dhaka", "motijheel");
        City city2 = new City("cumilla", "chandina");
        cityList.add(city);

        cityList.add(city1);
        cityList.add(city2);
        assertEquals(3, cityList.count());
        cityList.delete(city);
        assertEquals(2, cityList.count());
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(1)));
    }

    /**
     * tests if the sorting happens according to parameter p
     */
    @Test
    public void testsort(){
        CityList cityList = new CityList();
        City city1 = new City("cumilla","muradnagar");
        City city2 = new City("dhaka","azimpur");
        cityList.add(city1);
        cityList.add(city2);
        assertEquals(0,city2.compareTo(cityList.getCities(0).get(0)));
        assertEquals(0,city1.compareTo(cityList.getCities(0).get(1)));
    }
}
