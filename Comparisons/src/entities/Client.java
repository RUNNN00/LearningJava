package entities;

import java.util.Objects;

public class Client {

		private String email;
		private String name;
		
		public Client() {}
		
		public Client(String email, String name) {
			this.email = email;
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public int hashCode() {
			return Objects.hash(email, name);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Client other = (Client) obj;
			return Objects.equals(email, other.email) && Objects.equals(name, other.name);
		}
		
		
}
