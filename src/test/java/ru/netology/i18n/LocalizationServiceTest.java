package ru.netology.i18n;

import org.junit.Assert;
import org.junit.Test;
import ru.netology.entity.Country;

public class LocalizationServiceTest {

    @Test
    public void test_locale_by_country() {

        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

        Assert.assertEquals("Добро пожаловать", localizationService.locale(Country.RUSSIA));
        Assert.assertEquals("Welcome", localizationService.locale(Country.USA));
    }
}
