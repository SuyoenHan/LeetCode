class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         
         String orderedStr="";
	 Map<String,String> paraMap= new HashMap<>();
		 
	// 1) 같은 문자로 이루어 져있는지 확인=> array로 split / 정렬 후 join => 정렬된 문자열을 key값으로 사용 
	for(int i=0;i<strs.length;i++) {
            if("".equals(strs[i])) strs[i]="-1"; // ""의 경우 사용되지 않는 문자 "-1"로 교체     
	    String[] strArr= strs[i].split("");
	    Arrays.sort(strArr);
	    orderedStr=String.join("",strArr);
            // System.out.println(orderedStr);
            if(paraMap.containsKey(orderedStr)) paraMap.put(orderedStr, paraMap.get(orderedStr)+" "+strs[i]);
		   else paraMap.put(orderedStr, strs[i]);
        }  // end of for(int i=0;i<strs.length;i++) {----------
		 
		
	 // 2) 맵에 담긴 value들을 split하여 각각 list에 담기 == 같은 애니어그램끼리 list로 묶기
	 List<List<String>> answerList= new ArrayList<>();
	 List<String> eachList= null;
	 Set<String> paraMapKeys= paraMap.keySet();

	 for(String key: paraMapKeys) {
		eachList=new ArrayList<>(); // 초기화
		String[] valuesArr= paraMap.get(key).split(" ");
		for(String str: valuesArr) {
			if("-1".equals(str)) str="";  // 1)에서 -1로 바꿔준 ""을 
			eachList.add(str);
		}
		answerList.add(eachList);
	 } // end of for(String key: paraMapKeys) {-------------------

	 return answerList;
    }
}
