package resources;

public enum ApiRs {

    AddNewPet("v2/pet"),
    FindPetByID("v2/pet"),
    UpdatePet("v2/pet");

    private String apiRs;

    ApiRs(String apiRs) {
        this.apiRs = apiRs;
    }

    public String getApiRs() {
        return apiRs;
    }

}
