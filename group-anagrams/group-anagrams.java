class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
	// 1) 문자열을 정렬시켜서 키 값으로 사용
	Map<String,List<String>> map= new HashMap<>();

	for(String str:strs) {
		char[] strArr= str.toCharArray();
		Arrays.sort(strArr);
		String orderedStr= String.valueOf(strArr);

		// 2) map에 존재하지 않는 경우 실행
		map.putIfAbsent(orderedStr, new ArrayList<>());

		// 3) map에서 해당 키 값의 value(List)에 추가
		map.get(orderedStr).add(str);
	}

	// 4) 리스트 안의 리스트 형태로 리턴
	return new ArrayList<>(map.values());
    }
}
