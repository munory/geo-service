package ru.netology.geo;

import org.junit.Test;
import ru.netology.entity.Country;

import static org.junit.Assert.assertEquals;

public class GeoServiceTest {

    @Test
    public void test_location_by_ip() {

        GeoServiceImpl geoService = new GeoServiceImpl();

        assertEquals(Country.RUSSIA, geoService.byIp("172.12.3.23").getCountry());

        assertEquals(Country.USA, geoService.byIp("96.12.3.23").getCountry());
    }
}
