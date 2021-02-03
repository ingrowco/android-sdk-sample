package co.ingrow.android.sample;

import co.ingrow.android.action.InGrowClient;
import co.ingrow.android.action.InGrowProject;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // You could initialize anywhere you like but before any other action with InGrowClient
        // If you don't want to use Enrichment, you could use the other constructor of InGrowProject
        InGrowClient.initialize(new InGrowClient.Builder(new InGrowProject("api-key", "project-name-or-number", "stream", /*isLoggingEnable*/true, /*anonymous_id*/"any_number_but_unique_for_each_user", /*user_id*/null), this).build());

        // When debug mode is enabled, all exceptions will be thrown immediately, otherwise they will be logged and reported to any callbacks, but never thrown.
        InGrowClient.client().setDebugMode(true);
    }
}
