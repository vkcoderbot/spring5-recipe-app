package guru.springframework.service;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(long l);

    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
