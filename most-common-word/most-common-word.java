class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        // 1) 대소문자를 구별하지 않도록 모두 소문자로 만들기
		paragraph= paragraph.toLowerCase();

        // 2) 정규표현식을 사용하여 구두점 제거
        paragraph= paragraph.replaceAll("[^0-9a-zA-Z]"," ");
        
        // 2-1) 구두점 제거된 문장을 공백을 기준으로 split
        String[] paragraphArr= paragraph.split(" ");

        // 3) 문자들을 map에 담아서 카운드
        Map<String,Integer> paraMap= new HashMap<>();
        for(int i=0;i<paragraphArr.length;i++) {

            if(paraMap.containsKey(paragraphArr[i])) { // 이미 담겨있는 경우
                paraMap.put(paragraphArr[i], paraMap.get(paragraphArr[i])+1);
            }
            else { // 담겨져있지 않은 경우
                paraMap.put(paragraphArr[i], 1);
            }
        } // end of for(int i=0;i<paragraphArr.length;i++) {-------

		// 4) map에 담긴 단어 중 빈도수가 가장 높은 단어 추출 => 금지된 단어 제외
        // 4-1) 금지된 단어 배열을 하나의 문자열로 만들어서 비교
		StringBuilder sb= new StringBuilder();
		for(String bannedWord:banned) {
			sb.append(bannedWord);
		}

		String bannedWords= sb.toString();
		String commonWord= "";
		int frequency=0;

		Set<String> paraMapKeys= paraMap.keySet();

		for(String key:paraMapKeys) {
			if(bannedWords.indexOf(key)==-1 && paraMap.get(key)>frequency) { // 금지된 단어가 아니면서 빈도수가 큰 경우
				frequency=paraMap.get(key);
				commonWord=key;
			}
		}

		return commonWord;
    } // end of public String mostCommonWord(String paragraph, String[] banned) {-------
}