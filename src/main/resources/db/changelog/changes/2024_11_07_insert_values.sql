INSERT INTO coffee(id, name, recipe, image, coffee_beans, sugar, chocolate, water, milk)
VALUES (1, 'americano', 
            'With regular drip coffee, you put your coffee grounds into the machine and let the hot water soak the grinds until it starts to drip into the carafe.', 
            'https://www.taylorlane.com/cdn/shop/articles/Delicious-Homemade-Americano_1024x1024.jpg?v=1605897263',
            2, 0, 0, 90, 0),
    (2, 'cappuccino', 
            'Add a teaspoon of Coffee beans to your cup. If you like sugar you can add it now. Carefully pour hot water into the cup and stir to ensure coffee and sugar are fully dissolved. In a microwave-safe bowl, gently heat milk in microwave until warm, not boiling (approx 40 seconds). Once warmed, whisk the milk vigorously until you reach the desired frothiness. Pour the frothy milk into the cup of coffee and sprinkle drinking chocolate powder on top.',
            'https://www.nescafe.com/nz/sites/default/files/2023-09/NESCAF%C3%89%20Cappuccino.jpg',
            2, 1, 2, 60, 30),
    (3, 'espresso', 
            'simply add 2 teaspoons of coffee to a small cup, add a dribble of cold water, mix lightly using a teaspoon and then top up with 30ml of hot water and stir', 
            'https://www.thespruceeats.com/thmb/DIUuY3Fj_51rINr-vN4KQD2Js24=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/what-is-espresso-765702-hero-03_cropped-ffbc0c7cf45a46ff846843040c8f370c.jpg',
            2, 0, 0, 30, 0);

INSERT INTO ingridients(id, name, measure, quantity, image)
VALUES (1, 'Coffee Beans', 'teaspoon', 50000, 'https://upload.wikimedia.org/wikipedia/commons/c/c5/Roasted_coffee_beans.jpg'),
        (2, 'Sugar', 'teaspoon', 50000, 'https://www.tasteofhome.com/wp-content/uploads/2019/11/sugar-shutterstock_615908132.jpg?fit=300,300&webp=1'),
        (3, 'Chocolate', 'cubes', 50, 'https://vaya.in/recipes/wp-content/uploads/2018/02/Milk-Chocolate-1.jpg'),
        (4, 'Milk', 'ml', 3000,'https://en.wikipedia.org/wiki/Milk#/media/File:Glass_of_Milk_(33657535532).jpg'),
        (5, 'Water', 'ml', 3000,'https://ocdn.eu/pulscms-transforms/1/xU-k9kqTURBXy8zZjQzYmQ4ZjYxYzRjZjIxZWY2YWE3OTI0ZTUyZTQ3ZS5qcGVnkpUDAMxlzQJazQFSkwXNAxbNAa7eAAKhMAahMQAhttps://ocdn.eu/pulscms-transforms/1/xU-k9kqTURBXy8zZjQzYmQ4ZjYxYzRjZjIxZWY2YWE3OTI0ZTUyZTQ3ZS5qcGVnkpUDAMxlzQJazQFSkwXNAxbNAa7eAAKhMAahMQAs');