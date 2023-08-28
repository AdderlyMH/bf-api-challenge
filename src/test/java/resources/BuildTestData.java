package resources;

import pojo.Category;
import pojo.Pet;
import pojo.Tag;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildTestData {

    public Pet addPetPayload(int id, int cat_id, String cat_name, String name, String photoUrls, int tags_id,
                             String tags_name, String status) {

        Category category = new Category();
        category.setId(cat_id);
        category.setName(cat_name);

        String[] photoUrlElements = photoUrls.split(", ");
        List<String> urls = new ArrayList<>(Arrays.asList(photoUrlElements));

        Tag tag = new Tag();
        tag.setId(tags_id);
        tag.setName(tags_name);
        Tag[] tagsArray = { tag };

        Pet pet = new Pet();
        pet.setId(id);
        pet.setCategory(category);
        pet.setName(name);
        pet.setPhotoUrls(urls);
        pet.setTags(tagsArray);
        pet.setStatus(status);

        return pet;

    }

    public String addPetFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/main/resources/" + fileName + ".json")));
    }

}
