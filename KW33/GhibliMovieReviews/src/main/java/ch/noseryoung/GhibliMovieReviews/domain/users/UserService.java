package ch.noseryoung.GhibliMovieReviews.domain.users;

import org.springframework.stereotype.Service;

@Service
public class UserService {} /* implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return repository.findByUserName(name).map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException(name));
    }

    public record UserDetailsImpl(User user) implements UserDetails {
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return user.getUserRoles().getRoleAuth().stream()
                    .map(a -> new SimpleGrantedAuthority(a.getAuthName()))
                    .toList();
        }

        @Override
        public String getPassword() {
            return user.getPs();
        }

        @Override
        public String getUsername() {
            return user.getUserName();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }}*/
