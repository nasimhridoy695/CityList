package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * deletes the given city, if does not exist throws exceptions
     * @param city
     * city to delete
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * returns size of citylist
     * @return
     *
     */
    public int count(){
        return cities.size();
    }

    /**
     * This returns a sorted list of cities
     * Return the sorted list of cities if p = 1
     * else return sorted list of provinces if p = 0
     * @return
     *returns sorted list of city
     *
     */
    public List<City> getCities(int p) {
        List<City> cityList = cities;
        if(p == 1){
            Collections.sort(cityList);
        }
        else if (p == 0)
        {
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City city, City t1) {
                    return city.getProvinceName().compareTo(t1.getProvinceName());
                }
            });
        }

        return cityList;
    }



}
