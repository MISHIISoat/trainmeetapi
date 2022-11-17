package fr.soat.trainmeet.api.meeting.infrastructure;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JpaAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;


    public static final class JpaAccountBuilder {
        private Long id;
        private String email;
        private String password;

        private JpaAccountBuilder() {
        }

        public static JpaAccountBuilder builder() {
            return new JpaAccountBuilder();
        }

        public JpaAccountBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public JpaAccountBuilder email(String email) {
            this.email = email;
            return this;
        }

        public JpaAccountBuilder password(String password) {
            this.password = password;
            return this;
        }

        public JpaAccount build() {
            JpaAccount jpaAccount = new JpaAccount();
            jpaAccount.id = this.id;
            jpaAccount.email = this.email;
            jpaAccount.password = this.password;
            return jpaAccount;
        }
    }
}
