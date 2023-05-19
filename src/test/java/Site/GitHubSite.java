package Site;

import Pages.ContributorsPage;
import Pages.MainPage;
import Pages.ProjectPage;
import Pages.SearchPage;
import io.qameta.atlas.webdriver.WebSite;
import io.qameta.atlas.webdriver.extension.Page;
import io.qameta.atlas.webdriver.extension.Path;
import io.qameta.atlas.webdriver.extension.Query;

public interface GitHubSite extends WebSite {

    @Page
    MainPage onMainPage();

    @Page(url = "search")
    SearchPage onSearchPage(@Query("q") String value);

    @Page(url = "{profile}/{project}/tree/master/")
    ProjectPage onProjectPage(@Path("profile") String profile, @Path("project") String project);

    @Page
    ContributorsPage onContributorsPage();

}
