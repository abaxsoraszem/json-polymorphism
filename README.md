json-polymorphism
=================

Instantiate the PolymorphicAdapter as your base class for the root of your polymorphism

''' [source, java]
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(IAnimal.class, new PolymorficAdapter<IAnimal>());
		gsonExt = builder.create();


'''  