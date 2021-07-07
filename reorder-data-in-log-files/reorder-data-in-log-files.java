class Solution {
    public String[] reorderLogFiles(String[] logs) {
        // 식별자를 제외하고 구성된 문자로 사전순 나열 (문자로그 => 숫자로그)
	// 문자로그의 모든 문자가 같은 경우 식별자 사전순으로 나열
		
	List<String> sLogFiles= new ArrayList<>(); // 문자로그
	List<String> nLogFiles= new ArrayList<>(); // 숫자로그
		
	// ** 숫자로만 구성되어있는지 확인하기 위해 Integer.parseInt와 Long.parseLong 사용해 봤으나 해당 범위 초과하는 테스트케이스 존재 => isApharbetic으로 코딩 변경
	for(int i=0;i<logs.length;i++) {
		String[] eachLogArr= logs[i].split(" ");
		if(Character.isAlphabetic(eachLogArr[1].charAt(0))) sLogFiles.add(logs[i]);  // 문자로그 => 사전순 정렬 필요
		else nLogFiles.add(logs[i]); // 숫자로그 => 따로 정렬 필요 없음
	} // end of for(int i=0;i<logs.length;i++) {----------------
        
	// 2) 문자로그 정렬하기=> 버블정렬
	int startIndex1=0;
	int startIndex2=0;

	String content1= "";
	String content2= "";
	String temp="";
		
	for(int i=0;i<sLogFiles.size()-1;i++) { // 기준 비교점

		for(int j=i+1;j<sLogFiles.size();j++) { // 비교대상
			startIndex1=sLogFiles.get(i).indexOf(' ')+1;
		    	content1=sLogFiles.get(i).substring(startIndex1);

			startIndex2=sLogFiles.get(j).indexOf(' ')+1;
			content2=sLogFiles.get(j).substring(startIndex2);

			if(content1.compareTo(content2)==0) { // 식별자 제외 문자가 같은 경우 => 식별자 비교
				content1=sLogFiles.get(i).substring(0,startIndex1-1);
				content2=sLogFiles.get(j).substring(0,startIndex2-1);
				if(content1.compareTo(content2)>0) { // content1이 content2보다 큰 경우
					temp= sLogFiles.get(i);
					sLogFiles.set(i, sLogFiles.get(j));
					sLogFiles.set(j, temp);
				}
			}
			else if(content1.compareTo(content2)>0) { // 식별자 제외 문자가 다른 경우 
				temp= sLogFiles.get(i);
				sLogFiles.set(i, sLogFiles.get(j));
				sLogFiles.set(j, temp);
			}
		}
	} // end of for----------------------------------------
		
	// 3) 최종 배열 리턴하기
	String[] reorderLogFiles= new String[logs.length];
	for(int i=0;i<sLogFiles.size();i++) {
		reorderLogFiles[i]=sLogFiles.get(i);
	}
	for(int i=sLogFiles.size();i<nLogFiles.size()+sLogFiles.size();i++) {
		reorderLogFiles[i]=nLogFiles.get(i-sLogFiles.size());
	}

	return reorderLogFiles;
    }
}
