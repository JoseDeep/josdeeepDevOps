package com.railway.service;

import com.railway.model.Booking;
import com.railway.repository.BookingRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository repo;
    public BookingService(BookingRepository repo) { this.repo = repo; }

    public Booking save(Booking b) { return repo.save(b); }
    public List<Booking> pending() { return repo.findByConfirmedFalse(); }
    public List<Booking> all() { return repo.findAll(); }
    public Optional<Booking> find(Long id) { return repo.findById(id); }
}
package com.service;

public class BookingService {

}
