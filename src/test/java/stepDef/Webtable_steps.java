package stepDef;

import base.Config;
import io.cucumber.java.en.And;
import pageObject.Webtable_handeling;

public class Webtable_steps extends Config {
    Webtable_handeling webtable=new Webtable_handeling(driver);
    @And("I will verify firstName,lastName and email from WebTable recently created")
    public void iWillVerifyFirstNameLastNameAndEmailFromWebTableRecentlyCreated() {
        webtable.webtableHandeling();
    }
}
