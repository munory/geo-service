package ru.netology.sender;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderTest {

    @Test
    public void test_send_by_ru_ip() {

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(Mockito.<String>any())).thenReturn(new Location("Moscow", Country.RUSSIA,
                "Lenina", 24));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Mockito.<Country>any())).thenReturn("Добро пожаловать!");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "107.234.213.123");

        Assert.assertEquals("Добро пожаловать!", messageSender.send(headers));
    }

    @Test
    public void test_send_by_usa_ip() {

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(Mockito.<String>any())).thenReturn(new Location("New York", Country.USA,
                "11th Street", 5));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Mockito.<Country>any())).thenReturn("Welcome!");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "107.234.293.123");

        Assert.assertEquals("Welcome!", messageSender.send(headers));
    }
}
