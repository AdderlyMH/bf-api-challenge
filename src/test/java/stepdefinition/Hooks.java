package stepdefinition;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@FindPet or @UpdatePet")
    public void beforeScenario() throws IOException {

        StepDefinition sd = new StepDefinition();
        if (StepDefinition.pet_id == null) {

            sd.aPayloadFileNamed("addPet");
            sd.userSendsARequestFromTheAPI("POST");
            sd.theResponseStatusCodeIs(200);

        }

    }

}
