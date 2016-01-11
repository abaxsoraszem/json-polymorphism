import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AnimalTest {

	@Test
	public void test() {
		IAnimal animals[] = new IAnimal[] { new Cat("Kitty"), new Dog("Brutus", 5) };
		Gson gsonExt = null;

		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(IAnimal.class, new PolymorficAdapter<IAnimal>());
		gsonExt = builder.create();

		for (IAnimal animal : animals) {
			String animalJson = gsonExt.toJson(animal, IAnimal.class);
			System.out.println("serialized with the custom serializer:" + animalJson);
			IAnimal animalDeserialised = gsonExt.fromJson(animalJson, IAnimal.class);
			Assert.assertEquals(animal.sound(), animalDeserialised.sound());
			Assert.assertEquals(animal.getClass(), animalDeserialised.getClass());
		}
	}
}