package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    static boolean checkSame(String nickname1, String nickname2){
        for(int i=0; i<nickname1.length()-1;i++){
            if(nickname2.contains(nickname1.substring(i,i+2))){
                return true;
            }
        }
        return false;
    }

    static Map<String, String> changeToMap(List<List<String>> forms){
        Map<String, String> nickname_email_map;

        nickname_email_map = Stream.of(forms).flatMap(List::stream)
                .collect(Collectors.toMap(i -> i.get(1), i ->i.get(0)));

        return nickname_email_map;
    }

    static List<String> extractNickname(List<List<String>> forms){
        List<String> nickname_list;

        nickname_list = Stream.of(forms).flatMap(List::stream)
                .flatMap(List::stream)
                .filter(s->!s.contains("@"))
                .collect(Collectors.toList());
        return nickname_list;
    }

    static boolean checkID(String nickname1, List<String> nickname_list){
        for(String nickname2:nickname_list){
            if(checkSame(nickname1, nickname2)){
                return true;
            }
        }
        return false;
    }

    static List<String> findSameNickname(List<String> nickname_list){
        List<String> same_nickname_list = new ArrayList<>();

        for (String nickname:nickname_list){
            if(checkID(nickname, nickname_list)){
                same_nickname_list.add(nickname);
            }
        }
        return same_nickname_list;
    }

    static List<String> findEmail(List<String> same_nickname_list, Map<String, String> nickname_email_map){
        List<String> email_list = new ArrayList<>();

        for(String nickname:same_nickname_list){
            email_list.add(nickname_email_map.get(nickname));
        }
        return email_list;
    }
}