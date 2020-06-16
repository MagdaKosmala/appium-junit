package las3007.appium.tests;

import las3007.appium.activities.*;
import las3007.appium.utilis.PropertyReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WatchlistTest extends BaseTest {
    private AccountActivity account;

    @BeforeEach
    void setup() {
        LoginActivity login = new LoginActivity(driver);
        login.login();
        AuthActivity auth = new AuthActivity(driver);
        auth.submitLoginForm(email,password);
        auth.allowNotifcation();
        account = new HomeActivity(driver).loadAccout();
    }

    @Test
    void testWatchlist() throws IOException {
        WatchlistActivity watchlist = account.loadWatchlist();
        int watchlistActual = Integer.parseInt(PropertyReader.getValue("watchlist"));

        assertEquals("Your Watchlist", watchlist.getWatchlistHeader());
        assertTrue(watchlist.getWatchlistResults().size() >= watchlistActual);
    }

    @Test
    void testWatchlistMoviesFilter() throws IOException {
        WatchlistActivity watchlist = account.loadWatchlist();
        watchlist.filterWatchlistMovies();

        int moviesActual = Integer.parseInt(PropertyReader.getValue("movies"));

        assertTrue(watchlist.getWatchlistResults().size() == moviesActual);
    }

    @Test
    void testWatchlistSeriesFilter() throws IOException {
        WatchlistActivity watchlist = account.loadWatchlist();
        watchlist.filterWatchlistSeries();

        int seriesActual = Integer.parseInt(PropertyReader.getValue("series"));

        assertTrue(watchlist.getWatchlistResults().size() >= seriesActual);
    }
}
