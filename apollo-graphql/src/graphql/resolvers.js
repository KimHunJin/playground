import movies from '../db/movies';
import users from '../db/users';

const resolvers = {
	Query: {
		movies: () => movies,
		movie: (_, { id }) => {
			return movies.filter(movie => movie.id === id)[0];
		},
		users: () => users
	},
	Mutation: {
		addMovie: (_, { name, rating }) => {
			if (movies.find(movie => movie.name === name)) return null;

			const newMovie = {
				id: movies.length + 1,
				name,
				rating
			};
			movies.push(newMovie);
			return newMovie;
		},
		addUser: (_, { ID, password }) => {
			if (users.find(user => user.ID === ID)) return null;

			const newUser = {
				id: users.length + 1,
				ID,
				password
			};
			users.push(newUser);
			return newUser;
		}
	}
};

export default resolvers;
