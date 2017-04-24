package no.stelar7.api.l4j8.tests.summoner;


import no.stelar7.api.l4j8.basic.constants.api.*;
import no.stelar7.api.l4j8.impl.*;
import no.stelar7.api.l4j8.pojo.summoner.Summoner;
import no.stelar7.api.l4j8.tests.SecretFile;
import org.junit.*;

import java.util.function.Consumer;
import java.util.logging.Logger;

public class SummonerTest
{
    
    private static final Logger LOGGER = Logger.getGlobal();
    
    private final Consumer<Summoner> doAssertions = (final Summoner value) ->
    {
        Assert.assertNotNull("Summoner name is NULL", value.getName());
        Assert.assertNotEquals("Summoner profile icon is NULL", value.getProfileIconId(), (Integer) 0);
        Assert.assertNotEquals("Summoner revision date is NULL", value.getRevisionDate(), (Long) 0L);
        Assert.assertNotEquals("Summoner level is NULL", value.getSummonerLevel(), (Integer) 0);
        Assert.assertNotNull("Summoner revison date DATE is NULL", value.getRevisionDateAsDate());
    };
    
    final L4J8 l4j8 = new L4J8(SecretFile.CREDS);
    SummonerAPI api = l4j8.getSummonerAPI();
    
    @Test
    public void testById()
    {
        Summoner optional = api.getSummonerById(Platform.EUW1, Constants.TEST_SUMMONER_IDS[0]);
        doAssertions.accept(optional);
    }
    
    @Test
    public void testByName()
    {
        Summoner optional = api.getSummonerByName(Platform.EUW1, Constants.TEST_SUMMONER_NAMES[0]);
        doAssertions.accept(optional);
        
        optional = api.getSummonerByName(Platform.EUW1, Constants.TEST_SUMMONER_NAMES[1]);
        doAssertions.accept(optional);
    }
    
    @Test
    public void testByAccount()
    {
        Summoner optional = api.getSummonerByAccount(Platform.EUW1, Constants.TEST_ACCOUNT_IDS[0]);
        doAssertions.accept(optional);
    }
}
