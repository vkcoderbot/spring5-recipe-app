package guru.springframework.bootstrap;

import guru.springframework.domain.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeRepository recipeRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    private void loadData() throws Exception {
        Optional<Category> categoryMaxicanOptional = categoryRepository.findByDescription("Mexican");
        Optional<Category> categoryAmericalOptional = categoryRepository.findByDescription("American");

        {
            Recipe recipeGuacamole  = new Recipe();
            recipeGuacamole.setDescription("How to Make Perfect Guacamole Recipe");
            recipeGuacamole.setPrepTime(10);
            recipeGuacamole.setCookTime(0);
            recipeGuacamole.setDifficulty(Difficulty.EASY);
            recipeGuacamole.setServings(4);
            recipeGuacamole.addCategory(categoryMaxicanOptional.get());
            recipeGuacamole.addCategory(categoryAmericalOptional.get());
            recipeGuacamole.setSource("www.simplyrecipes.com BY ELISE BAUER");
            recipeGuacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
            recipeGuacamole.setDirections(new StringBuilder().append("Be careful handling chiles if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours.").append("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon.")
                    .append("\n").append("2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n")
                    .append("\n").append("3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n")
                    .append("\n").append("Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n")
                    .append("\n").append("Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n")
                    .append("\n").append("Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n")
                    .append("\n").append("4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.").toString());
            Notes notes = new Notes();
            recipeGuacamole.setNotes(notes);
            notes.setRecipeNotes(new StringBuilder().append("The trick to making perfect guacamole is using ripe avocados that are just the right amount of ripeness. Not ripe enough and the avocado will be hard and tasteless. Too ripe and the taste will be off.\n")
                    .append("\n")
                    .append("Check for ripeness by gently pressing the outside of the avocado. If there is no give, the avocado is not ripe yet and will not taste good. If there is a little give, the avocado is ripe. If there is a lot of give, the avocado may be past ripe and not good. In this case, taste test first before using.").toString());


            recipeGuacamole.addIngredient(getIngredient(new BigDecimal(2), "ripe avocados","Count"))
                    .addIngredient(getIngredient(new BigDecimal(0.24), "teaspoon of salt, more to taste","Teaspoon"))
                    .addIngredient(getIngredient(new BigDecimal(2), "to 1/4 cup of minced red onion or thinly sliced green onion","Tablespoon"))
                    .addIngredient(getIngredient(new BigDecimal(2), "serrano chiles, stems and seeds removed, minced","Count"))
                    .addIngredient(getIngredient(new BigDecimal(2), "cilantro (leaves and tender stems), finely chopped","Tablespoon"))
                    .addIngredient(getIngredient(new BigDecimal(1), "dash of freshly grated black pepper","Count"))
                    .addIngredient(getIngredient(new BigDecimal(0.5), "ripe tomato, seeds and pulp removed, chopped","Count"))
                    .addIngredient(getIngredient(new BigDecimal(1), "Red radishes or jicama, to garnish","Count"))
                    .addIngredient(getIngredient(new BigDecimal(1), "Tortilla chips, to serve","Count"));

            recipeRepository.save(recipeGuacamole);
        }

        {
            Recipe recipeGrilledChiken  = new Recipe();
            recipeGrilledChiken.setDescription("Spicy Grilled Chicken Tacos Recipe");
            recipeGrilledChiken.setPrepTime(20);
            recipeGrilledChiken.setCookTime(16);
            recipeGrilledChiken.setServings(6);
            recipeGrilledChiken.addCategory(categoryMaxicanOptional.get());
            recipeGrilledChiken.addCategory(categoryAmericalOptional.get());
            recipeGrilledChiken.setDifficulty(Difficulty.MODERATE);
            recipeGrilledChiken.setSource("www.simplyrecipes.com BY SALLY VARGAS");
            recipeGrilledChiken.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
            recipeGrilledChiken.setDirections(new StringBuilder().append("Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)")
                    .append("1 Prepare a gas or charcoal grill for medium-high, direct heat.")
                    .append("\n").append("2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over. Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n")
                    .append("\n").append("3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n")
                    .append("\n").append("4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side. Wrap warmed tortillas in a tea towel to keep them warm until serving.\n")
                    .append("\n").append("5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n").toString());
            Notes notes = new Notes();
            recipeGrilledChiken.setNotes(notes);
            notes.setRecipeNotes(new StringBuilder().append("First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                    "\n" +
                    "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!").toString());

            recipeGrilledChiken.addIngredient(getIngredient(new BigDecimal(2), "ancho chili powder","Tablespoon"))
                    .addIngredient(getIngredient(new BigDecimal(1), "dried oregano","Tablespoon"))
                    .addIngredient(getIngredient(new BigDecimal(1), "dried cumin","Tablespoon"))
                    .addIngredient(getIngredient(new BigDecimal(1), "sugar","Tablespoon"))
                    .addIngredient(getIngredient(new BigDecimal(0.05), "salt","Tablespoon"))
                    .addIngredient(getIngredient(new BigDecimal(1), "clove garlic, finely chopped","Count"))
                    .addIngredient(getIngredient(new BigDecimal(1), "finely grated orange zest","Tablespoon"))
                    .addIngredient(getIngredient(new BigDecimal(3), "fresh-squeezed orange juice","Tablespoon"))
                    .addIngredient(getIngredient(new BigDecimal(2), "olive oil","Tablespoon"))
                    .addIngredient(getIngredient(new BigDecimal(6), "oneless chicken thighs (1 1/4 pounds)","Count"))
                    .addIngredient(getIngredient(new BigDecimal(8), "small corn tortillas","Count"))
                    .addIngredient(getIngredient(new BigDecimal(3), "packed baby arugula (3 ounces)","Cup"))
                    .addIngredient(getIngredient(new BigDecimal(2), "medium ripe avocados, sliced","Count"))
                    .addIngredient(getIngredient(new BigDecimal(4), "radishes, thinly sliced","Count"))
                    .addIngredient(getIngredient(new BigDecimal(0.5), "cherry tomatoes, halved","Pint"))
                    .addIngredient(getIngredient(new BigDecimal(0.25), "red onion, thinly sliced","Count"))
                    .addIngredient(getIngredient(new BigDecimal(1), "Roughly chopped cilantro","Count"))
                    .addIngredient(getIngredient(new BigDecimal(0.5), "cup sour cream thinned with 1/4 cup milk","Cup"));

            recipeRepository.save(recipeGrilledChiken);
        }


    }

    private Ingredient getIngredient(BigDecimal amount, String description, String unitOfMeasure){
        return new Ingredient(amount, description, unitOfMeasureRepository.findByDescription(unitOfMeasure).get());
    }


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("I am inside bootstrap!!");
        try {
            loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
