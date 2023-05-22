package peaksoft.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Customer;
import peaksoft.enums.Gender;
import peaksoft.service.CustomerService;

@Controller
@RequestMapping("/customers/{agencyId}")
public class CustomerApi {
    private final CustomerService customerService;

    public CustomerApi(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping()
    public String getAllCustomer(@PathVariable Long agencyId, Model model){
        model.addAttribute("customer",customerService.getAllCustomers());
        model.addAttribute(agencyId);
        return "customers/mainCustomer";
    }

    @GetMapping("/new")
    public String createCustomer(@PathVariable Long agencyId,Model model){
        model.addAttribute("newCustomer",new Customer());
        model.addAttribute(agencyId);
        model.addAttribute("male", Gender.MALE.name());
        model.addAttribute("female", Gender.FEMALE.name());
        return "customers/newCustomer";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("newCustomer") Customer customer,
                               @PathVariable Long agencyId) {
        customerService.saveCustomer(customer);
        return "redirect:/customers/" + agencyId;
    }

    @DeleteMapping("/delete/{customerId}")
    public String deleteCustomerById(@PathVariable Long agencyId,
                                     @PathVariable Long customerId){
        customerService.deleteCustomerByID(customerId);
        return "redirect:/customers/{agencyId}";
    }

    @GetMapping("/edit/{customerId}")
    public String editCustomer(@PathVariable Long agencyId,
                               @PathVariable Long customerId,Model model){
        model.addAttribute("customer",customerService.getCustomerById(customerId));
        return "customers/updateCustomer";
    }
    @PutMapping("/update/{customerId}")
    public String updateCustomer(@PathVariable Long agencyId,
                                 @PathVariable Long customerId,
                                 @ModelAttribute ("customer") Customer customer){
        customerService.updateCustomer(customerId,customer);
        return "redirect:/customers/{agencyId}";
    }
}
