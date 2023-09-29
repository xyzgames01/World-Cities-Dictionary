package com.hash.dictionaryadt;

public class WorldCities {

        public String city, city_ascii, country, iso2, iso3, admin_name, capital, population, id;
        double lat, lng;

        public WorldCities(String[] data){
            this.city = data[0];
            this.city_ascii = data[1];
            this.lat = Double.parseDouble(data[2].replaceAll("^\"|\"$", ""));
            this.lng = Double.parseDouble(data[3].replaceAll("^\"|\"$", ""));
            this.country = data[4];
            this.iso2 = data[5];
            this.iso3 = data[6];
            this.admin_name = data[7];
            this.capital = data[8];
            this.population = data[9];
            this.id = data[10];
        }

        public String toString(){

            return String.format("City: %s Latitude: %f Longitude: %f", city, lat, lng);
//            return String.format("City: %s City ASCII: %s, Latitude: %f, Longitude: %f Country: %s Iso2: %s, Iso3: %s " +
//                        "Admin Name: %s Capital: %s, Population: %s, ID: %s",city,city_ascii,lat,lng,country,iso2,iso3,
//                admin_name,capital,population,id);
        }

}
