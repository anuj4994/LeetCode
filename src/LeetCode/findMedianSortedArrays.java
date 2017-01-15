/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Problem Defination 

//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//
//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n))
package LeetCode;

/**
 *
 * @author Anuj Shah
 */
public class findMedianSortedArrays {
        
    public static void main(String[] args){
            
        int nums1[] = new int[]{1,3};
        int nums2[] = new int[]{2};
        int nums1Size = nums1.length;
        int nums2Size = nums2.length;
        int temp = 0;
        int[] nums3 = new int[nums1Size + nums2Size];
        for (int i = 0; i < (nums3.length); i++) {
            if(temp == nums2.length){
                nums3[i] = nums1[i-temp];
            }
            else if (((i-temp)<(nums1.length)) && (nums1[i-temp] < nums2[temp])){
                    nums3[i] = nums1[i-temp];
            }
            else{
                nums3[i] = nums2[temp];
                temp++;
            }
        }
        if((nums1Size + nums2Size)%2==0){
            System.out.println((nums3[((nums1Size + nums2Size)/2) -1] + nums3[((nums1Size + nums2Size)/2)] )/2.0);
        } else {
            System.out.println(nums3[(nums1Size + nums2Size)/2]);
        }
    }
}
