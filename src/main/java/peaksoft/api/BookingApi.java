package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Booking;
import peaksoft.entity.Customer;
import peaksoft.service.BookingService;
import peaksoft.service.CustomerService;
import peaksoft.service.HouseService;

@Controller
@RequestMapping("/bookings/{agencyId}")
@RequiredArgsConstructor
public class BookingApi {
    private final BookingService bookingService;
    private final HouseService houseService;
    private final CustomerService customerService;


    @GetMapping
    public String getAllBooking(@PathVariable Long agencyId, Model model){
        model.addAttribute("booking",bookingService.getAll());
        model.addAttribute(agencyId);
        return "bookings/mainBooking";

    }

    @GetMapping("/new")
    public String createBooking(@PathVariable Long agencyId,
                                Model model){
        model.addAttribute("newBooking",new Booking());
        model.addAttribute("customers",customerService.getAllCustomers());
        model.addAttribute("houses",houseService.getAllHouses(agencyId));
        model.addAttribute(agencyId);
        return "bookings/newBooking";
    }

    @PostMapping("/save")
    public String saveBooking(@ModelAttribute("newBooking") Booking booking,
                              @RequestParam("houseId") Long houseId,
                              @RequestParam("customerId") Long customerId){
        bookingService.saveBooking(customerId,houseId,booking);
        return "redirect:/bookings/{agencyId}";
    }
}
