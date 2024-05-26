package org.example.friendexam.컨트롤러;
import lombok.RequiredArgsConstructor;
import org.example.friendexam.도메인.POST;
import org.example.friendexam.서비스.FriendService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/friends")
public class FriendController {
    private final FriendService friendService;

    // 글 리스트
    @GetMapping
    public String friends(Model model, @RequestParam(defaultValue = "1") int page,
                          @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        Page<POST> friends = friendService.findAllFriends(pageable);
        model.addAttribute("friends", friends);
        model.addAttribute("currentPage", page);
        return "friends/list";
    }


    // 글 추가 폼
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("friend", new POST());
        return "friends/form";
    }

    @PostMapping("/add")
    public String addFriend(@ModelAttribute POST friend) {
        friendService.saveFriend(friend);

        return "redirect:/friends";
    }


    //친구상세페이지
    @GetMapping("/{id}")
    public String detailFriend(@PathVariable Long id, Model model) {



        POST friend = friendService.findFriendById((Long) id);
        model.addAttribute("friend", friend);
        return "friends/detail";
    }



    // 글 상세페이지
    @GetMapping("title/{id}")
    public String detailPost(@PathVariable Long id, Model model) {



        POST friend = friendService.findFriendById((Long) id);
        model.addAttribute("friend", friend);
        return "friends/title";
    }


    // 글 삭제
    @GetMapping("/delete/{id}")
    public String deleteFriend(@PathVariable Long id) {
        friendService.deleteFriendById(id);
        return "friends/delete";
    }

    @GetMapping("/delete")
    public String deletefriend(){
        return "redirect:/friends";
    }

    //수정 localhost/friends/edit/{id}  -- Get  수정폼
    //수정 localhost/friends/edit/{id}  -- Post  수정
    //Get, Post둘 다 url이 같다. 하지만 오류가 나지 않는다.

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) { // 수정 폼에 값을 넣어야 함으로 모델을 쓴다.
        model.addAttribute("friend", friendService.findFriendById(id));

        return "friends/edit";
    }

    @PostMapping("/edit/{id}")
    public String editFriend(@ModelAttribute POST friend) {
        friendService.saveFriend(friend);
        return "redirect:/friends";
    }


    //비밀번호 확인
    @GetMapping("/check/{id}")
    public String Check(@PathVariable Long id, Model model){
        POST friend = friendService.findFriendById((Long) id);
        model.addAttribute("friend", friend);

        return "friends/check";
    }

    @PostMapping("/check/{id}")
    public String Check1(@RequestParam("password") String password, @PathVariable("id") Long id) {
        POST post = friendService.findFriendById((Long) id);
        if (post != null && post.getPassword().equals(password)) {

            return "redirect:/friends/{id}";
        } else {
            return "redirect:/friends/fail"; // 왜 안되냐??
        }


    }

}